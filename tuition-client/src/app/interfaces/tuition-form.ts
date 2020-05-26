import { Time } from '@angular/common';

export interface TuitionForm {
    first_name: string,
    last_name: string,
    start_date: string,
    start_time: string,
    location: string,
    description: string,
    cost: number,
    event_type: string, 
    user_id: number,
    grade_id: number
}