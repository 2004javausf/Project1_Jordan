import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { UserComponent } from './components/user/user.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { TuitionFormComponent } from './components/tuition-form/tuition-form.component';
import { EmployeeComponent } from './components/employee/employee.component';
import { LoginComponent } from './login/login.component';
import { TuitionFormDetailComponent } from './components/tuition-form-detail/tuition-form-detail.component';
import { SubmittedFormsComponent } from './components/submitted-forms/submitted-forms.component'

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    TuitionFormComponent,
    EmployeeComponent,
    LoginComponent,
    TuitionFormDetailComponent,
    SubmittedFormsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
