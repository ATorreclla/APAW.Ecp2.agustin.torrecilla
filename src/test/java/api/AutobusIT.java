package api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;

import api.entities.Conductor;
import api.apiControllers.AutobusApiController;
import api.daos.DaoFactory;
import api.dtos.AutobusDto;
import api.daos.memory.DaoMemoryFactory;

public class AutobusIT {

    @BeforeAll
    static void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    @Test
    void testCreateAutobus() {
        this.createAutobus();
    }

    @Test
    void testAutobusInvalidRequest() {
        HttpRequest request = HttpRequest.builder(AutobusApiController.AUTOBUSES + "/invalid").body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCreateConductorWithoutConductorDto() {
        HttpRequest request = HttpRequest.builder(AutobusApiController.AUTOBUSES).body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    private String createAutobus() {
        HttpRequest request = HttpRequest.builder(AutobusApiController.AUTOBUSES).body(new AutobusDto(45, new Conductor("Isabel Garcia","656534365"))).post();
        return (String) new Client().submit(request).getBody();
    }
}
