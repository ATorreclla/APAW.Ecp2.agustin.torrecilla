package api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;

import api.apiControllers.ControlCalidadApiController;
import api.daos.DaoFactory;
import api.dtos.ControlCalidadDto;
import api.daos.memory.DaoMemoryFactory;

public class ControlCalidadIT {

    @BeforeAll
    static void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    @Test
    void testCreateControlCalidad() {
        this.createControlCalidad();
    }

    @Test
    void testConductorInvalidRequest() {
        HttpRequest request = HttpRequest.builder(ControlCalidadApiController.CONTROLCALIDADES + "/invalid").body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCreateConductorWithoutConductorDto() {
        HttpRequest request = HttpRequest.builder(ControlCalidadApiController.CONTROLCALIDADES).body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCreateConductorWithoutConductorDtoName() {
        HttpRequest request = HttpRequest.builder(ControlCalidadApiController.CONTROLCALIDADES).body(new ControlCalidadDto(null)).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    private String createControlCalidad() {
        HttpRequest request = HttpRequest.builder(ControlCalidadApiController.CONTROLCALIDADES).body(new ControlCalidadDto("Servicio puntual. Satisfactorio", true)).post();
        return (String) new Client().submit(request).getBody();
    }
}