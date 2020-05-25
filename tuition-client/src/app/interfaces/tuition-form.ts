import { Time } from '@angular/common';

export interface TuitionForm {
    first_name: string,
    last_name: string,
    start_date: Date,
    start_time: Time,
    location: string,
    description: string,
    cost: number,
    event_type: string, 
    attachments: object
}