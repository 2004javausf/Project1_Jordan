import { Component } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Employee } from './interfaces/employee';
import { User } from './interfaces/user';
import { EmployeeService } from './services/employee.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'tuition-client';

  myLogin: FormGroup;

  loading = false;
  success = false;
  isLoggedIn = false;

  employee: Employee = {
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

   // this.myLogin.valueChanges.subscribe(console.log);
  }

  async onClick() {
    this.loading = true;
    const formValue = this.myLogin.value;

    this.employeeService.getEmployee(formValue).subscribe((res) => {
      this.employee = res;
      this.isLoggedIn = true;
      console.log(this.employee);
    });
  }


}
