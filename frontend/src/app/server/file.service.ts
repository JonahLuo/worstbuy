import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable, of} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {User} from '../models/User';

@Injectable({
  providedIn: 'root'
})
export class FileService {

  fileResource: string;
  fileResourceURL: string;
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  cors = {
    headers: new HttpHeaders({ 'Access-Control-Allow-Origin': '*' })
  };

  /**
   * constructor
   */
  constructor(private http: HttpClient) {
    this.fileResource = 'file';
    this.fileResourceURL = `${environment.serverBaseURL}/${this.fileResource}`;
  }

  /**
   * Post: upload file to backend
   * @param file file to be uploaded
   */
  postFile(file: File): Observable<boolean> {
    const url = `${this.fileResourceURL}/uploadImg`;
    const formData: FormData = new FormData();
    formData.append('fileKey', file, file.name);
    return this.http.post(url, file, this.cors).pipe(
      catchError(this.handleError<any>(`upload Profile Image`))
    );
  }

  /**
   * Get: get file by id
   * @param id the id of the target image
   */
  getFile(id: string): Observable<File>{
    const url = `${this.fileResourceURL}/${id}`;
    return this.http.get<File>(url).pipe(
      catchError(this.handleError<File>(`getFile id=${id}`))
    );
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  // tslint:disable-next-line:typedef
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
