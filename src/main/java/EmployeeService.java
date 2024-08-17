import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private List<Employee> employeeList = new ArrayList<>();
    private int numberOfEmployees = 3;

    public void addEmployee (Employee employee){
        if (employeeList.size()==numberOfEmployees){
            throw new EmployeeStorageIsFullException();
        }
        try {
            searchEmployee(employee);
            throw new EmployeeAlreadyAddedException();
        } catch (EmployeeNotFoundException e) {
        }
        employeeList.add(employee);
    }

    public Employee searchEmployee (Employee employee){
        for (Employee exitingEmployee : employeeList){
            if (exitingEmployee.getFirstName().equals(employee.getFirstName()) && exitingEmployee.getLastName().equals(employee.getLastName())){
                return exitingEmployee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public void deleteEmployee(Employee employee) {
        Employee foundEmployee = searchEmployee(employee);
        employeeList.remove(foundEmployee);
    }
}
