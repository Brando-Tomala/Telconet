import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Rol } from '../interfaces/manager';
import { Response } from '../interfaces/response';

@Injectable({
  providedIn: 'root'
})
export class RolesService {


  pathRol:string= environment.rol;

  constructor(private _http:HttpClient) { }

  getRoles(){
    const path= this.pathRol;
    return this._http.get<Response>(path);
  }

  postRol(reqRol:Rol){
    const path= this.pathRol;
    return this._http.post<Response>(path, reqRol);
  }

  putRol(id:number, rol:string){
    const path= this.pathRol+id;
    const params={
        rol
    }
    return this._http.put<Response>(path, {}, {
      params
    });
  }

  deleteRol(id:number){
    const path= this.pathRol+id;
    return this._http.delete<Response>(path);
  }
}
