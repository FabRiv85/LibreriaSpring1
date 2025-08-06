//import { Autor } from "../services/autor"
//import { Categoria } from "./categoria.model"

export interface Libro{
    idLibro: number
    tituLibro: string
    editoLibro: string
    pagLibro: number
    edicLibro: string
    idioLibro: string
    fecPubLibro: Date
    descLibro: string
    pastLibro: string
    isbnLibro: string
    numEjeLibro: string
    portLibro:string
    preseLibro: string
    precLibro: number
    //categoria: Categoria
    //autor: Autor

    [key: string]: any;
}
