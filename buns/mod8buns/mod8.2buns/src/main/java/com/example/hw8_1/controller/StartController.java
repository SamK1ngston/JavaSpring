package com.example.hw8_1.controller;

import com.example.hw8_1.entity.Employee;
import com.example.hw8_1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Контроллер для взаимодействия с сущностью "Employee" через API.
 */
@RestController
@RequestMapping("/api")
public class StartController {

    /**
     * Сервис для управления сотрудниками.
     */
    @Autowired
    private EmployeeService service;

    /**
     * Возвращает список всех сотрудников.
     *
     * @return Список всех сотрудников.
     */
    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return service.getAll();
    }

    /**
     * Возвращает информацию о сотруднике по указанному идентификатору.
     *
     * @param id Идентификатор сотрудника.
     * @return Объект с информацией о сотруднике.
     */
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return service.getEmployee(id);
    }

    /**
     * Добавляет нового сотрудника.
     *
     * @param employee Новый сотрудник, переданный в теле запроса.
     * @return Добавленный сотрудник.
     */
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
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
    public Employee updateEmployee(@RequestBody Employee employee) {
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
        Employee employee = service.getEmployee(id);
        service.delete(id);
        return "Employee with id - " + id + " was deleted";
    }

    /**
     * Возвращает список сотрудников по указанному имени.
     *
     * @param name Имя сотрудника для поиска.
     * @return Список сотрудников с указанным именем.
     */
    @GetMapping("/employees/name/{name}")
    public List<Employee> findAllByName(@PathVariable String name) {
        return service.findAllByName(name);
    }
}
