import { Component, OnInit } from '@angular/core';
import {NB_STEPPER, NbStepperComponent} from '@nebular/theme';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {User} from '../../models/User';
import {Poster} from '../../models/Poster';
import {Categories} from '../../models/Categories';
import {PosterService} from '../../server/poster.service';
import {NbAuthJWTToken, NbAuthService} from '@nebular/auth';
import {UserService} from '../../server/user.service';
import {FileService} from '../../server/file.service';

@Component({
  selector: 'app-create-poster',
  templateUrl: './create-poster.component.html',
  styleUrls: ['./create-poster.component.scss'],
  providers: [{ provide: NB_STEPPER, useExisting: NbStepperComponent }],
})
export class CreatePosterComponent implements OnInit {

  form: any;
  poster: Poster;
  userid: string;
  profile: User;
  posterTitle: string;
  posterUrl: string;
  isLinear = false;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  comments: Comment[];
  categories = Categories;
  private fileToUpload: File = null;
  constructor(private posterService: PosterService,
              private authService: NbAuthService,
              private userService: UserService,
              private fileService: FileService,
              private formBuilder: FormBuilder) {
    this.authService.onTokenChange()
      .subscribe((token: NbAuthJWTToken) => {

        if (token.isValid()) {
          this.userid = token.getPayload()._id; // here we receive a payload from the token and assigns it to our `user` variable
        }

      });
    this.userService.getUserById(this.userid).subscribe(profile => this.profile = profile);
    this.poster = new Poster();
  }

  ngOnInit(): void {
    this.firstFormGroup = this.formBuilder.group({
      url: ['', Validators.required]
    });
    this.secondFormGroup = this.formBuilder.group({
      title: ['', Validators.required],
      tag: ['', Validators.required],
      description: ['']
    });
  }

  step1next() {
    if (this.getPosterImage(this.firstFormGroup.value.url)) {
      this.poster.seller = this.profile;
      this.poster.comments = this.comments;
      this.uploadFileToActivity();
      // this.nbStepperComponent.next();
    }
  }

  step2next() {
    this.poster.title = this.secondFormGroup.value.title;
    this.poster.tag = this.secondFormGroup.value.tag;
    this.poster.description = (this.secondFormGroup.value.description === undefined ? 'none' : this.secondFormGroup.value.description);
    this.poster.comments = new Array();
    this.posterService.uploadPoster(this.poster).subscribe();
  }

  getPosterImage(url: string): boolean {
    if (url !== undefined ) {
      const temp = url.replace('https://www.youtube.com/watch?v=', '');
      if (temp === null) { return false; }
      this.poster.url = temp;
      return true;
    }
    return false;
  }

  // tslint:disable-next-line:typedef
  upload(files: FileList) {
    this.fileToUpload = files.item(0);
  }

  uploadFileToActivity(): boolean {
    let message = false;
    this.fileService.postFile(this.fileToUpload).subscribe(
      data => {
        message = true;
      }, error => {
        console.log(error);
      }
    );
    return message;
  }
}
