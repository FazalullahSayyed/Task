import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { User } from './user';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class LoginuserService {
  private users = [
    { userId: 'user1', password: 'password123' },
    { userId: 'admin', password: 'admin456' },
    { userId: 'guest', password: 'guest789' }
  ];

  constructor(private authService: AuthService) {}

  loginUser(user: User): Observable<{ success: boolean }> {
    const foundUser = this.users.find(u => u.userId === user.userId && u.password === user.password);
    if (foundUser) {
      this.authService.login(); // Call login method on success
      return of({ success: true });
    }
    return of({ success: false });
  }
}
