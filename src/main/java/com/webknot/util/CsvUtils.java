package com.webknot.util;

import com.webknot.dto.EmployeeDTO;
import com.webknot.entity.Employee;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {

    public static List<Employee> parseCsvFile(MultipartFile file) {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader().withIgnoreHeaderCase().withTrim())) {
            for (CSVRecord record : csvParser) {
                Employee employee = new Employee();
                employee.setName(record.get("Name"));
                employee.setEmail(record.get("Email"));
                employee.setTechStack(record.get("Tech Stack"));
                employee.setYearsOfExperience(Integer.parseInt(record.get("Years of Experience")));
                employee.setYearsInWebknot(Integer.parseInt(record.get("Years in Webknot")));
                employees.add(employee);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse CSV file: " + e.getMessage());
        }
        return employees;
    }
}