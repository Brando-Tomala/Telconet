import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { UsuarioEdit, Usuario } from '../interfaces/manager';
import { Response } from '../interfaces/response';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  path:string = environment.usuario;

  constructor(private _http:HttpClient) { }

  getAllUsuarios(){
    return this._http.get<Response>(this.path);
  }

  postCrearUsuario(reqUser:Usuario){
    return this._http.post<Response>(this.path, reqUser);
  }

  putActualizarUsuario(id:number, request:UsuarioEdit){
    return this._http.put<Response>(this.path+id, request);
  }

  deleteEliminarUsuario(id:number){
    return this._http.delete<Response>(this.path+id);
  }
}
