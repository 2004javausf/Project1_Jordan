import { Component, OnInit } from '@angular/core';
import { TuitionForm } from 'src/app/interfaces/tuition-form';
import { FormService } from 'src/app/services/form.service';

@Component({
  selector: 'app-tuition-form-detail',
  templateUrl: './tuition-form-detail.component.html',
  styleUrls: ['./tuition-form-detail.component.css']
})
export class TuitionFormDetailComponent implements OnInit {

  form: TuitionForm;


  constructor(private formService: FormService) { }

  ngOnInit(): void {
  }

  getUserForm(): void {
    
  }

  

}
