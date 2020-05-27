import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TuitionFormComponent } from './components/tuition-form/tuition-form.component';
import { LoginComponent } from './login/login.component';


const routes: Routes = [
  { path: 'tuitionForm', component: TuitionFormComponent},
  {path: 'employee/login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
