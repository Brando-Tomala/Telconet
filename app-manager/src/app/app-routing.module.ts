import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AplicacionComponent } from './components/aplicacion/aplicacion.component';
import { MenuComponent } from './components/menu/menu.component';
import { RolesComponent } from './components/roles/roles.component';
import { UsuariosComponent } from './components/usuarios/usuarios.component';

const routes: Routes = [
  { path: 'usuarios', component: UsuariosComponent },
  { path: 'roles', component: RolesComponent},
  { path: 'aplicaciones', component: AplicacionComponent, 
  // children:[
  //   { path: 'consultaCompras', component: ListaComprasComponent},
  //   { path: '', component: ListaComprasComponent}         
  // ] 
},
  { path: '',   redirectTo: '/', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
