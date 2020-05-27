import { Component, OnInit } from '@angular/core';
import { User } from '../../interfaces/user';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  user: User = {
    user_id: 0,
    name: "",
    password: ""
  }

  users: User[];

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.getAllUsers();
  }

  getAllUsers(){
    this.userService.getAllUsers().subscribe(res => this.users = res);
  }

  onClick() {
    this.userService.addUser(this.user).subscribe(res => {
      this.user.name ="";
      this.user.password ="";
      this.getAllUsers();
    })
  }
}
