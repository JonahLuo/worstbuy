import { Component, OnInit, ViewChild, ElementRef, Renderer2, Input } from '@angular/core';
import { UserService } from '../../server/user.service';
import { ActivatedRoute } from '@angular/router';
import { NbAuthService, NbAuthJWTToken } from '@nebular/auth';
import { User } from 'src/app/models/User';
import {Poster} from '../../models/Poster';
import {PosterService} from '../../server/poster.service';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  @ViewChild('file1') file: ElementRef;


  Arr = Array.from(
    {length: Math.floor(Math.random() * 10)},
    (item, index) => {
      return {number: index, edit: false};
    }
  );

  tabs = [
    'User Info',
    'My poster',
    'Liked',
    'Transaction',
  ];
  tabKey = 'My poster';
  tabKeyL = 'Liked';
  tabKeyS = 'Subscription';
  tabKeyU = 'User-Info'

  buttonText = '';
  fileArr = [];

  userid: string;
  // posterurl: string;
  poster: Poster;

  user: User;
  posterid: string;
  posters: Array<Poster> = [];//my poster
  // posterIds: Array<string>;
  likes: Poster[]=[]; //likes 后面声明
  // realsub: Array<User>;
  sub: Poster[] = [];//看情况
  posterAuthors = new Map<string, User>();

  requestId: string;

  // picFile:File;

  constructor(private renderer: Renderer2,
              private authService: NbAuthService,
              private userService: UserService,
              public posterService: PosterService,
              private route: ActivatedRoute) {
    // this.sub =new Array();
    // this.posters =new Array(); //my poster
    // this.likes = new Array(); //likes声明数组 找like的poster
    //this.posterurl = this.posterService.getposterImgURL(this.poster.url);
    this.authService.onTokenChange()
      .subscribe((token: NbAuthJWTToken) => {

        if (token.isValid()) {
          this.requestId = token.getPayload().sub; // here we receive a payload from the token and assigns it to our `user` variable
          console.log(this.requestId);
        }
      });
    this.userService.getUserByEmail(this.requestId).subscribe(
      profile => this.user = profile
    );
  }



  ngOnInit(): void {
    this.getDataReady();
  }

  getDataReady(): void {
    // get all posters made by user
    this.userService.getUserByEmail(this.requestId).subscribe(
      profile => profile.posters.forEach(
          poster => {
            if(poster !== null && poster !== undefined) {this.posters.push(poster); }
          }
      )
    );

    // get all posters liked by user
    // this.userService.getUserById(this.requestId).subscribe(
    //   profile => profile.liked.forEach(
    //     posterid => this.posterService.getposterById(posterid).subscribe(
    //       poster => {
    //         if (poster !== null && poster !== undefined) {this.likes.push(poster); }
    //       }
    //     )
    //   )
    // );

    // // get all users followed by user
    // this.userService.getUserById(this.requestId).subscribe(
    //   profile => profile.subscribe.forEach(
    //     userid => this.userService.getUserById(userid).subscribe(
    //       user => user.posters.forEach(
    //         posterid => this.posterService.getposterById(posterid).subscribe(
    //           poster => {
    //             if (poster !== undefined && poster !== null) {
    //               this.sub.push(poster);
    //               this.posterAuthors.set(poster.id, user);
    //             }
    //           }
    //         )
    //       )
    //     )
    //   )
    // );

  }




  setKey(event): void {
    this.tabKey = event.tabTitle;

    this.Arr = Array.from(
      { length: Math.floor(Math.random() * 10) },
      (item, index) => {
        return {number: index, edit : false};
      }
    );
    switch (event.tabTitle) {
      case 'My poster':
        this.buttonText = 'Delete poster';
        break;
      case 'Liked':
        this.buttonText = 'Unlike';
        break;
      case 'Subscription':
        this.buttonText = 'Unsubscribe';
        break;
      default:
        this.buttonText = '';
    }
  }

  //save the user info that updated by user
  onSave() {
    this.userService.updateUser(this.user).subscribe();
    //save alert once save successfully
    alert('Save SUCCESSFULLY');
  }

  deleteItem(): void{

    this.Arr.forEach((item) => (item.edit = true));
    //  var deleteitem = confirm('Delete?')
    //  if(deleteitem){
    this.posterService.deleteposter(this.poster).subscribe();

    //}
    //window.location.assign('');
  }

  del(event, index): void{
    event.stopPropagation();
    this.Arr.splice(index, 1);
  }

  //local files open (prepare for upload)
  upload1(){
    this.file.nativeElement.click();
  }

  //upload profile image
  // upload(){
  //
  //   var file: File = this.fileArr.pop()
  //   var form = new FormData()
  //   form.append("file", file)
  //   this.userService.uploadProfileImg(form).toPromise().then();
  //
  //
  // }
  //
  //
  //
  //
  // editFlag: boolean = false;
  // editStatus(){
  //   this.editFlag = true;
  // }
  //
  // pageID = "home";
  // //pageID = "My poster";
  // posterData = {title: "123", edit: true, number: 1};
  // toEdit(data) {
  //   if (!this.editFlag || this.tabKey !== 'My poster') return;
  //   this.pageID = "edit";
  //   this.posterData = data;
  //   console.log(this.posterData);
  // }
  //
  // returnHome(){
  //   this.pageID = 'home';
  //   this.editFlag = false;
  // }
  //
  // editSAVE() {
  //   // this.pageID = "edit";
  //   alert('Save SUCCESSFULLY');
  // }

  //TODO
  //Add listener
  // ngAfterViewInit(): void {
    //Called after ngAfterContentInit when the component's view has been initialized. Applies to components only.
    //Add 'implements AfterViewInit' to the class.
    // this.renderer.listen(this.file.nativeElement, "change", (event) => {
    //   console.log(event);
    //   let files = event.target.files;
    //   this.fileArr = [];
    //   for(let index = 0; index < files.length; index++) {
    //     const file = files[index];
    //     let reader = new FileReader();
    //     reader.readAsDataURL(file);
    //     reader.onload = function (e) {
    //       file.url = this.result;
    //     };
    //     this.fileArr.push(file);
    //   }
    //   console.log(this.fileArr);
    //   this.file.nativeElement.value = "";
    // });
  // }
}
