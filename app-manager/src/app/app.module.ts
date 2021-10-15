import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';

/*PrimeNg*/
import {MenubarModule} from 'primeng/menubar';
import {MenuModule} from 'primeng/menu';
import {ButtonModule} from 'primeng/button';
import {TableModule} from 'primeng/table';
import {DialogModule} from 'primeng/dialog';
import {CheckboxModule} from 'primeng/checkbox';
import {InputTextModule} from 'primeng/inputtext';
import {InputTextareaModule} from 'primeng/inputtextarea';
import {DropdownModule} from 'primeng/dropdown';


/*Components*/
import { MenuComponent } from './components/menu/menu.component';
import { UsuariosComponent } from './components/usuarios/usuarios.component';
import { FormsModule } from '@angular/forms';
import { RolesComponent } from './components/roles/roles.component';
import { AplicacionComponent } from './components/aplicacion/aplicacion.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    UsuariosComponent,
    RolesComponent,
    AplicacionComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MenuModule,
    ButtonModule,
    MenubarModule,
    TableModule,
    DialogModule,
    CheckboxModule,
    FormsModule,
    InputTextareaModule,
    InputTextModule,
    HttpClientModule,
    BrowserAnimationsModule,
    DropdownModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
