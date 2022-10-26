import { UserService } from '../user.service';
import { User } from '../user';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent implements OnInit {

  user: User = new User();
  submitted = false;
  successSave = true;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  newUser(): void {
    this.submitted = false;
    this.successSave = false;
    this.user = new User();
  }

  save() {
    this.userService.registerUser(this.user).subscribe({
      next : (data) => {
        console.log(data);
        this.user = new User();
        this.goToList();
        this.successSave = true;
      },
      error : (err) => {
        console.log(err);
        this.successSave = false;
      }
    })
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  goToList() {
    this.router.navigate(['/users'])
  }
}
