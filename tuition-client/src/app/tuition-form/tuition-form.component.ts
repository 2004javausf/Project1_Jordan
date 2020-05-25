import { Component, OnInit } from '@angular/core';
import { FormService } from '../services/form.service';
import {TuitionForm} from '../interfaces/tuition-form'

@Component({
  selector: 'app-tuition-form',
  templateUrl: './tuition-form.component.html',
  styleUrls: ['./tuition-form.component.css']
})
export class TuitionFormComponent implements OnInit {

 form: TuitionForm; 

  constructor(private formService: FormService) { }

  ngOnInit(): void {
    
  }



}
