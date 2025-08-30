import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { App } from './app';
import { ClienteComponent } from './components/cliente/cliente';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule} from '@angular/material/paginator';
import { MatPaginator} from '@angular/material/paginator';
import { MatSortModule} from '@angular/material/sort';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LibroComponent } from './components/libro/libro';
import { MatSelectModule } from '@angular/material/select';
import { MatNativeDateModule, MatOptionModule } from '@angular/material/core';
import { MatDialogModule } from '@angular/material/dialog';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { AutorComponent } from './components/autor/autor';
import { CategoriaComponent } from './components/categoria/categoria';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardMdImage, MatCardModule } from '@angular/material/card';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
//import { Carrito } from './componentes/carrito/CarritoComponent';
import { MatMenuModule } from '@angular/material/menu';
import { CarritoComponent } from './components/carrito/carrito';
import { LibrosListComponent } from './components/libros-list/libros-list';


@NgModule({
  declarations: [
    App,
    ClienteComponent,
    AutorComponent,
    CategoriaComponent,
    LibroComponent,
    CarritoComponent,
    LibrosListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatInputModule,
    MatFormFieldModule,
    MatIconModule,
    MatButtonModule,
    BrowserAnimationsModule,
    MatSelectModule,
    MatOptionModule,
    MatDialogModule,
    MatDatepickerModule,
    MatNativeDateModule,
    ReactiveFormsModule,
    MatToolbarModule,
    MatCardModule,
    MatSnackBarModule,
    MatProgressSpinnerModule,
    MatMenuModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners()
  ],
  bootstrap: [App]
})
export class AppModule { }
