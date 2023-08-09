package skypro.employeeBook.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "В фирме уже есть такой сотрудник")

public class EmployeeAlreadyAddedException extends RuntimeException{
}
