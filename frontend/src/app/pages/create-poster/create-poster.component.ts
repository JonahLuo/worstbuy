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
  categories = Categories;
  selectedFile: File;
  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;
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
      title: ['', Validators.required]
    });
    this.secondFormGroup = this.formBuilder.group({
      subtitle: ['', Validators.required],
      tag: ['', Validators.required],
      description: [''],
      category: ['']
    });
  }


  step1next(): void{
    this.poster.seller = this.profile;
    this.poster.title = this.firstFormGroup.value.title;
    // this.poster.comments = this.comments;
    // this.upload();
  }

  step2next(): void{
    this.poster.title = this.secondFormGroup.value.subtitle;
    this.poster.tag = this.secondFormGroup.value.tag;
    this.poster.category = this.secondFormGroup.value.category;
    this.poster.description = (this.secondFormGroup.value.description === undefined ? 'none' : this.secondFormGroup.value.description);
    this.posterService.uploadPoster(this.poster).subscribe();
  }

  // getPosterImage(url: string): void {
  //   this.fileService.getFile(this.poster.id).subscribe(
  //     res = >{
  //       this.this.retrieveResonse = res;
  //       this.this.base64Data = this.retrieveResonse.picByte;
  //       this.this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
  //   }
  //   );
  // }

  // tslint:disable-next-line:typedef
  upload() {
    const uploadImageData = new FormData();
    uploadImageData.append('imageFile', this.selectedFile, this.selectedFile.name);
    this.fileService.postFile(uploadImageData).subscribe();
  }
  onFileChanged(event): void{
    this.selectedFile = event.target.files[0];
  }
}
