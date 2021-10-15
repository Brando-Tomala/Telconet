import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

 
  items: MenuItem[];


  constructor(private route:Router) { }

  ngOnInit() {
    
  
      this.items = [
        
        {
          label: 'Usuarios',
          icon: 'pi pi-list',
          routerLink: ['usuarios']
        },
        {
          label: 'Roles',
          icon: 'pi pi-list',
          routerLink: ['roles']
        },
        {
          label: 'Aplicaciones',
          icon: 'pi pi-list',
          routerLink: ['aplicaciones']
        }
      ];
  }
}
