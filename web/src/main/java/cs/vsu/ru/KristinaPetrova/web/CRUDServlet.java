package cs.vsu.ru.KristinaPetrova.web;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import cs.vsu.ru.KristinaPetrova.models.Identifiable;
import cs.vsu.ru.KristinaPetrova.repository.Repository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public abstract class CRUDServlet<T extends Identifiable> extends HttpServlet {
    // CREATE(post without id)
    // READ(get with id and without id)
    // UPDATE(post with id)
    // TODO DELETE(by id)


    protected final Class<T> tClass;
    private final Repository<T> tRepository;

    protected final ObjectWriter objectWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();
    protected final ObjectMapper objectMapper = new ObjectMapper();

    public CRUDServlet(Class<T> tClass, Repository<T> tRepository) {
        this.tClass = tClass;
        this.tRepository = tRepository;
    }

    protected final Integer getIdFromPath(String path){
        String[] params = path.split("/");

        if(params.length != 0 && params.length != 2) {
            throw new IllegalArgumentException("illegal path");
        }
        if(params.length == 0){
            return null;
        }
        try {
            return Integer.parseInt(params[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("illegal path");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id;
        try {
            id = getIdFromPath(request.getPathInfo());
        } catch (IllegalArgumentException e){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.toString());
            return;
        }

        Object value;
        if( id != null) {
            value = tRepository.getById(id);
        }
        else {
            value = tRepository.getAll();
        }

        if(value == null){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        PrintWriter out = response.getWriter();
        objectWriter.writeValue(out, value);
        out.flush();
    }


    protected abstract boolean validate(T obj);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getPathInfo().split("/").length != 0){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "illegal path");
            return;
        }

        request.getReader();
        T got = objectMapper.readValue(request.getReader(), tClass);

        if(!validate(got) && got.getID() != null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "error while parsing");
            return;
        }
        try {
            tRepository.add(got);
            PrintWriter out = response.getWriter();
            objectWriter.writeValue(out, got);
            out.flush();
        }
        catch (RuntimeException e){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "error appending in db");
        }
    }


    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getPathInfo().split("/").length != 0){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "illegal path");
            return;
        }

        request.getReader();
        T got = objectMapper.readValue(request.getReader(), tClass);

        if(!validate(got) && got.getID() == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "error while parsing body");
            return;
        }
        try {
            tRepository.update(got.getID(), got);
        }
        catch (RuntimeException e){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "error appending in db" + e.toString());
            return;
        }
        response.sendError(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
        Integer id;
        try {
            id = getIdFromPath(request.getPathInfo());
        } catch (IllegalArgumentException e){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "error parsing id");
            return;
        }

        if( id == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "error parsing id");
            return;
        }

        try {
            tRepository.delete(id);
        } catch (RuntimeException e){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "error deleting from db");
        }
        response.sendError(HttpServletResponse.SC_OK);
    }


}
