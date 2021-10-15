export interface Rol {
  id: number;
  rol: string;
}

export interface Usuario {
  id: number;
  apellido: string;
  celular: string;
  correo: string;
  direccionDomicilio: string;
  fechaNacimiento: string;
  nombre: string;
  nombreUsuario: string;
  roles: Rol[];
}
export interface Aplicacion {
  id: number;
  aplicacion: string;
  roles: Rol[];
}

export interface UsuarioEdit {
  nombre: string;
  apellido: string;
  celular: string;
  direccionDomicilio: string;
  roles: Rol[];
}
