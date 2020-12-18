import { Component, OnInit } from '@angular/core';
import {User} from '../../models/User';
import {Poster} from '../../models/Poster';
import {ActivatedRoute} from '@angular/router';
import {UserService} from '../../server/user.service';
import {PosterService} from '../../server/poster.service';

@Component({
  selector: 'app-otherprofile',
  templateUrl: './otherprofile.component.html',
  styleUrls: ['./otherprofile.component.scss']
})
export class OtherprofileComponent implements OnInit {
  profile: User;
  followClicked = true;
  posters: Poster[] = [];

  constructor(private route: ActivatedRoute,
              private userService: UserService,
              public posterService: PosterService) { }

  ngOnInit(): void {
    this.getUser();
    this.getPosters();
  }

  getUser(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.userService.getUserById(id).subscribe(profile => this.profile = profile);
  }

  getPosters(): void {
    this.posterService.getAllPostersFromSeller(this.route.snapshot.paramMap.get('id')).subscribe(
      posters => posters.forEach(video => this.posters.push(video))
    );
  }


  // addFollow(): void{
  //   if (!this.followClicked) {
  //     this.userService.subscribeUser(this.profile).toPromise().then();
  //
  //   } else {
  //     this.userService.unSubscribeUser(this.profile).toPromise().then()
  //   }
  // }

}
