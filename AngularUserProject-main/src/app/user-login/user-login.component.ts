import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import { LoginuserService } from '../loginuser.service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.scss']
})
export class UserLoginComponent {
  user: User = new User();
  isLoading: boolean = false; // Optional loading state

  constructor(private loginuserservice: LoginuserService, private router: Router) {}

  userLogin() {
    this.isLoading = true; // Set loading state

    this.loginuserservice.loginUser(this.user).subscribe(
      data => {
        this.isLoading = false; // Reset loading state
        if (data.success) { // Check for success
          alert("Login Successfully");
          this.router.navigate(['/home']); // Navigate to home on success
        } else {
          alert("Invalid credentials, please try again."); // Error message
        }
      },
      error => {
        this.isLoading = false; // Reset loading state
        alert("Sorry, please enter the correct UserId and Password");
      }
    );
  }
}
