import { Observable } from "rxjs";
import { Employee } from "./employee";

export class EmployeeService {

    private apiServiceUrl = '';

    constructor(private http: HttpClient){}

    public getEmployees(): Observable<Employee[]> {
        return this.http.get<Employee[]>(`${this.apiServiceUrl}/employee/getAllEmployees`);
    }

    public addEmployees(employee: Employee): Observable<Employee> {
        return this.http.post<Employee>(`${this.apiServiceUrl}/employee/addEmployee`, employee);
    }

    public updateEmployees(employee: Employee): Observable<Employee> {
        return this.http.put<Employee>(`${this.apiServiceUrl}/employee/updateEmployee`, employee);
    }


    public deleteEmployees(employeeId: number): Observable<void> {
        return this.http.delete<void>(`${this.apiServiceUrl}/employee/deleteEmployee/${employeeId}`);
    }
}