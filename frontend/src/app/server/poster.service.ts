import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable, of} from 'rxjs';
import {User} from '../models/User';
import {catchError} from 'rxjs/operators';
import {Poster} from '../models/Poster';

@Injectable({
  providedIn: 'root'
})
export class PosterService {

  posterResource: string;
  posterResourceURL: string;
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
    this.posterResource = 'poster';
    this.posterResourceURL = `${environment.serverBaseURL}/${this.posterResource}`;
  }

  /**
   * GET: to get the Poster by id
   * @param id the target poster id
   */
  getPosterById(id: string): Observable<Poster> {
    const url = `${this.posterResourceURL}/${id}`;
    return this.http.get<Poster>(url).pipe(
      catchError(this.handleError<Poster>(`getUser id=${id}`))
    );
  }


  /**
   * Get: to get the posters from the same category
   * @param category the target poster's category
   */
  getPostersByCategory(category: string): Observable<Poster[]> {
    const url = `${this.posterResourceURL}s?category=${category}`;
    return this.http.get<Poster[]>(url).pipe(
      catchError(this.handleError<Poster[]>(`getPoster category = ${category}`))
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
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }


  uploadPoster(poster: Poster): Observable<any> {
    const url = `${this.posterResourceURL}`;
    return this.http.post<any>(url, poster, this.cors).pipe(
      catchError(this.handleError<any>('upload poster'))
    );
  }

  deleteposter(poster: Poster): Observable<any>{
    const url = `${this.posterResourceURL}\${poster.id}`;
    return this.http.delete<any>(url, this.cors).pipe(
      catchError(this.handleError<any>('upload poster'))
    );
  }
}
