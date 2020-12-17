import { Component, OnInit } from '@angular/core';
import {NbMenuItem, NbLayoutComponent} from '@nebular/theme';
import {User} from '../../models/User';
import {NbAuthJWTToken, NbAuthService} from '@nebular/auth';
import {UserService} from '../../server/user.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  item: NbMenuItem[] = [
    {
      title: 'profile',
      link: '/pages/profile'
    },
    {
      title: 'history',
      link: '/pages/history'
    },
    { title: 'logout',
      link: '/auth/logout'}
  ];

  userid;
  profile: User;
  user1: User;
  user2: User;
  // video: Video;
  // videos: Video[];

  // @ts-ignore
  constructor(private authService: NbAuthService, private userService: UserService) {

    this.authService.onTokenChange()
      .subscribe((token: NbAuthJWTToken) => {

        if (token.isValid()) {
          this.userid = token.getPayload()._id; // here we receive a payload from the token and assigns it to our `user` variable
        }

      });

    // console.log(this.userid);
    userService.getUserById(this.userid).subscribe(profile => this.profile = profile);
    // console.log(this.profile);
  }

  ngOnInit(): void {
  }

}
