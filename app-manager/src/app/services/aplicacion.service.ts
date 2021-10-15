import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Aplicacion } from '../interfaces/manager';
import { Response } from '../interfaces/response';

@Injectable({
  providedIn: 'root'
})
export class AplicacionService {

  path:string= environment.aplicacion;

  constructor(private _http:HttpClient) { }

  getApp(){
    return this._http.get<Response>(this.path);
  }

  postApp(request:Aplicacion){
    return this._http.post<Response>(this.path, request);
  }

  putApp(id:number, app:string){
    const params={
        app
    }
    return this._http.put<Response>(this.path+id, {}, {
      params
    });
  }

  deleteApp(id:number){
    return this._http.delete<Response>(this.path+id);
  }
}
