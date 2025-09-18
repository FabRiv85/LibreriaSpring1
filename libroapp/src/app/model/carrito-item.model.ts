import { Libro } from "./libro.model";

export interface CarritoItem{
    idCarritoItem?: number;
    itlibro: Libro;
    itcantidad: number;
    itprecioUnitario: number;
    ittotal: number;   
}