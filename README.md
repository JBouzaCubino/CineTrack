# 🎬 CineTrack

**CineTrack** es una aplicación Android desarrollada en **Kotlin** que te permite **buscar, guardar y gestionar tus películas favoritas** de forma sencilla e intuitiva.  
La app utiliza la API de **IMDbAPI** (API no oficial) para ofrecer información sobre películas y series de televisión, y emplea una arquitectura **MVVM** con **Hilt**, **Retrofit**, y **DataStore**.

---

## 📚 Tabla de Contenidos
- [Características](#-características)
- [Funcionalidades](#-funcionalidades)
- [Arquitectura](#-arquitectura)
- [Tecnologías Utilizadas](#-tecnologías-utilizadas)
- [Uso](#-uso)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Flujo de Ramas](#-flujo-de-ramas)
- [Paleta de Colores](#-paleta-de-colores)
- [Capturas](#-capturas-cuando-esté-listo)

---

## 🌟 Características

- 🔍 **Búsqueda de películas** por título mediante la API de TMDB.  
- ❤️ **Guardar películas favoritas** localmente.  
- 🧾 **Gestión y visualización** de la lista de películas guardadas.  
- ⚡ **Actualización en tiempo real** usando *Coroutines* y *Flow*.  
- 🧭 **Navegación fluida** gracias a *Navigation Component*.  
- 🧠 **Inyección de dependencias** con *Dagger Hilt*.  
- 💾 **Persistencia ligera** de datos con *DataStore Preferences*.  
- 🖼️ **Carga eficiente de imágenes** con *Glide*.

---

## 🧩 Funcionalidades

- 🏠 **Home:** muestra una lista de películas populares obtenidas de TMDB.  
- 📖 **Detalles:** despliega sinopsis, puntuación, géneros y portada de la película.  
- ⭐ **Favoritos:** permite marcar y persistir películas localmente.  
- ⚙️ **Configuración:** cambio de tema (claro/oscuro), idioma y filtros personalizados.  
- 🔄 **Navegación:** fluida e intuitiva entre las diferentes secciones de la app.  

---

## 🏗️ Arquitectura

El proyecto sigue una **arquitectura MVVM (Model-View-ViewModel)** basada en el patrón de repositorio para garantizar una separación clara de responsabilidades, mantenibilidad y escalabilidad.

```
UI (Activities / Fragments)
        ↓
ViewModel (LiveData / StateFlow)
        ↓
Repository (Manejo de datos)
        ↓
Data Sources (Remote + Local)
```

---

### 🧩 Manejo de estados con *sealed classes*

CineTrack utiliza **sealed classes** para modelar los distintos estados de las pantallas (por ejemplo, *Home*, *Details*, *Favorites*).  
Este enfoque permite manejar de forma clara y segura los estados de carga, éxito o error en la capa de presentación, manteniendo el código más legible y predecible.

---

## 🧰 Tecnologías Utilizadas

| Componente              | Descripción |
|--------------------------|-------------|
| **Kotlin**               | Lenguaje principal del proyecto. |
| **MVVM + Repository**    | Arquitectura modular y escalable. |
| **Retrofit**             | Cliente HTTP para consumir la API de TMDB. |
| **Dagger Hilt**          | Inyección de dependencias. |
| **DataStore Preferences**| Almacenamiento local de datos clave-valor. |
| **Coroutines + Flow**    | Programación asíncrona y reactiva. |
| **Navigation Component** | Gestión de la navegación entre pantallas. |
| **Glide**                | Carga y manejo de imágenes. |

---

## ▶️ Uso

1. Ejecuta la app en un emulador o dispositivo Android.  
2. Usa la barra de búsqueda para encontrar películas.  
3. Guarda tus películas favoritas para verlas más tarde.  
4. Gestiona tu lista desde la sección de “Favoritos”.  
5. Personaliza la app desde el menú de **Configuración**.

---

## 📁 Estructura del Proyecto

(pendiente)

---

## 🌿 Flujo de Ramas

El flujo de trabajo de desarrollo se organiza según las siguientes ramas:

- **`main`** → contiene la versión **estable** y lista para producción.  
- **`feature/...`** → ramas individuales para nuevas características o mejoras.  

---

## 🎨 Paleta de Colores

CineTrack utiliza un esquema visual adaptable con soporte para **modo claro** y **modo oscuro**, basado en el estilo “Cine Moderno”.

### ☀️ Modo Claro

| Función                  | Nombre XML         | Código Hex  |
|--------------------------|--------------------|--------------|
| 🎬 **Primario**          | `primary`          | `#3F51B5`    |
| ⚙️ **Secundario**        | `secondary`        | `#B0BEC5`    |
| 🖼️ **Fondo**             | `background`       | `#F5F5F5`    |
| 🧱 **Superficie (cards)**| `surface`          | `#E0E0E0`    |
| 📝 **Texto principal**   | `primary_text`     | `#212121`    |
| 💬 **Texto secundario**  | `secondary_text`   | `#757575`    |
| 🎯 **Color de acento**   | `accent`           | `#E53935`    |

---

### 🌙 Modo Oscuro

| Función                  | Nombre XML         | Código Hex  |
|--------------------------|--------------------|--------------|
| 🎬 **Primario**          | `primary`          | `#8B0000`    |
| ⚙️ **Secundario**        | `secondary`        | `#CDAA55`    |
| 🖼️ **Fondo**             | `background`       | `#0B0C10`    |
| 🧱 **Superficie (cards)**| `surface`          | `#1F1F1F`    |
| 📝 **Texto principal**   | `primary_text`     | `#F5F5F5`    |
| 💬 **Texto secundario**  | `secondary_text`   | `#B8B8B8`    |
| 🎯 **Color de acento**   | `accent`           | `#FFD369`    |

> 📘 **Nota:**  
> Los archivos de colores se definen en:
> - `res/values/colors.xml` → *modo claro*  
> - `res/values-night/colors.xml` → *modo oscuro*

---

## 📱 Capturas (cuando esté listo)

*(pendiente)*

<!--
Puedes agregar tus capturas aquí más adelante, por ejemplo:
![Pantalla principal](screenshots/home.png)
![Detalles de película](screenshots/details.png)
-->

---

💬 **Autor:** Jesús Bouza Cubino  
📧 **Contacto:** jbouzacub@gmail.com  
