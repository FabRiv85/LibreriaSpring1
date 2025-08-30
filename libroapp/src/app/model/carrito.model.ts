import { CarritoItem } from "./carrito-item.model";
import { Cliente } from "./cliente.model";

export interface Carrito{
    idCarrito?: number;
    cliente?: Cliente;
    items: CarritoItem[];
    subtotal: number;
    descuento: number;
    impuesto: number;
    total: number;
    actualizadoEn?: string; 
}