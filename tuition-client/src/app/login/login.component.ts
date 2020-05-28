import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../services/employee.service';
import { Employee } from '../interfaces/employee';
import { User } from '../interfaces/user';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  myLogin: FormGroup;

  loading = false;
  success = false;
  isLoggedIn = false;

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



  constructor(
    private fb: FormBuilder,
    private employeeService: EmployeeService
    ) { }

  ngOnInit(): void {
    this.myLogin = this.fb.group({
      name: '',
      password: ''
    })
    
    this.myLogin.valueChanges.subscribe(console.log);
  }
  
   async onClick(){
    this.loading = true;
    const formValue = this.myLogin.value;

    this.employeeService.getEmployee(formValue).subscribe((res) => {
      this.employee = res;
      this.isLoggedIn = true;
      console.log(this.employee);
    });
  }



  



}
