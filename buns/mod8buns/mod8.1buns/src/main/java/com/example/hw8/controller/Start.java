package com.example.hw8.controller;

import com.example.hw8.entity.Emp;
//import com.example.hw8.error.NoSuchEmployeeException;
import com.example.hw8.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для взаимодействия с сущностью "Employee" через API.
 */
@RestController
@RequestMapping("/api")
public class Start {

    /**
     * Сервис для управления сотрудниками.
     */
    @Autowired
    private EmpService service;

    /**
     * Возвращает список всех сотрудников.
     *
     * @return Список всех сотрудников.
     */
    @GetMapping("/employees")
    public List<Emp> showAllEmployees() {
        return service.getAll();
    }

    /**
     * Возвращает информацию о сотруднике по указанному идентификатору.
     *
     * @param id Идентификатор сотрудника.
     * @return Объект с информацией о сотруднике.
     */
    @GetMapping("/employees/{id}")
    public Emp getEmployeeById(@PathVariable int id) {
        return service.getEmployee(id);
    }

    /**
     * Добавляет нового сотрудника.
     *
     * @param employee Новый сотрудник, переданный в теле запроса.
     * @return Добавленный сотрудник.
     */
    @PostMapping("/employees")
    public Emp addEmployee(@RequestBody Emp employee) {
        service.save(employee);
        return employee;
    }

    /**
     * Обновляет информацию о существующем сотруднике.
     *
     * @param employee Существующий сотрудник с обновленными данными, переданный в теле запроса.
     * @return Обновленный сотрудник.
     */
    @PutMapping("/employees")
    public Emp updateEmployee(@RequestBody Emp employee) {
        service.save(employee);
        return employee;
    }

    /**
     * Удаляет сотрудника по указанному идентификатору.
     *
     * @param id Идентификатор сотрудника для удаления.
     * @return Сообщение об успешном удалении сотрудника.
     */
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Emp employee = service.getEmployee(id);
        service.delete(id);
        return "Employee with id - " + id + " was deleted";
    }
}
