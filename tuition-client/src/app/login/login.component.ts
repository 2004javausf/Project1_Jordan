import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../services/employee.service';
import { Employee } from '../interfaces/employee';
import { User } from '../interfaces/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  employee: Employee ={
    employee_id: 0,
    first_name: "",
    last_name: "",
    tuition_limit: 0,
    user_id: 0,
    dept_id: 0

  }

  user: User = {
    user_id: 0,
    name: "",
    password: ""
  }

  isLoggedIn = false;

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
  }
  
  onClick(){
    this.employeeService.getEmployee(this.user).subscribe((res) => {
      this.employee = res;
      this.isLoggedIn = true;
      console.log(this.employee);
    });
  }

  



}
