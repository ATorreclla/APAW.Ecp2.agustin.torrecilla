package api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;

import api.apiControllers.ConductorApiController;
import api.daos.DaoFactory;
import api.dtos.ConductorDto;
import api.daos.memory.DaoMemoryFactory;

public class ConductorIT {

    @BeforeAll
    static void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    @Test
    void testCreateConductor() {
        this.createConductor();
    }

    private String createConductor() {
        HttpRequest request = HttpRequest.builder(ConductorApiController.CONDUCTORES).body(new ConductorDto("ManuelRodriguez")).post();
        return (String) new Client().submit(request).getBody();
    }

    @Test
    void testConductorInvalidRequest() {
        HttpRequest request = HttpRequest.builder(ConductorApiController.CONDUCTORES + "/invalid").body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCreateConductorWithoutConductorDto() {
        HttpRequest request = HttpRequest.builder(ConductorApiController.CONDUCTORES).body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCreateConductorWithoutConductorDtoName() {
        HttpRequest request = HttpRequest.builder(ConductorApiController.CONDUCTORES).body(new ConductorDto(null)).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testUpdateConductor() {
        String id = this.createConductor();
        HttpRequest request = HttpRequest.builder(ConductorApiController.CONDUCTORES).path(ConductorApiController.ID_PUT)
                .expandPath(id).body(new ConductorDto("dos")).put();
        new Client().submit(request);
    }

    @Test
    void testUpdateConductorWithoutUserDto() {
        String id = this.createConductor();
        HttpRequest request = HttpRequest.builder(ConductorApiController.CONDUCTORES).path(ConductorApiController.ID_PUT)
                .expandPath(id).body(null).put();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testUpdateConductorNotFoundException() {
        HttpRequest request = HttpRequest.builder(ConductorApiController.CONDUCTORES).path(ConductorApiController.ID_PUT)
                .expandPath("FAILURE").body(new ConductorDto("dos")).put();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
       assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus());
    }
}
