import { UserService } from '../user.service';
import { User } from '../user';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent implements OnInit {

  user: User = new User();
  submitted = false;

  constructor(private userService: UserService, private router: Router,
    private toast: NgToastService) { }

  ngOnInit(): void {
  }

  newUser(): void {
    this.submitted = false;
    this.user = new User();
  }

  save() {
    this.userService.registerUser(this.user).subscribe({
      next : (data) => {
        console.log(data);
        this.user = new User();
        this.toast.success({
          detail: 'User registered successfully!',
          duration: 5000
        });
        this.goToList();
      },
      error : (err) => {
        this.toast.error({
          detail: 'The operation failed.',
          duration: 5000
        });
        console.log(err);
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
