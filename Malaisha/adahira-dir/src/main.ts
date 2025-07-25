const urlApiAlbum = '/api/album';

class Album {
    id: number;
    name: string;
    ctime: string;
    mtime: string;

    constructor(id: number, name: string, ctime: string, mtime: string) {
        this.id = id;
        this.name = name;
        this.ctime = ctime;
        this.mtime = mtime;
    }
}

async function malaishaGetAlbum() {
    const responseRaw = await fetch(urlApiAlbum);
    const response = await responseRaw.json();

    console.log("response= ", response);

    const album = new Album(
        response.id,
        response.name,
        response.ctime,
        response.mtime
    );

    console.log("album= ", album);
}

export function malaishaReady(fn: (this: Document, ev: Event) => any) {
    if (document.readyState !== 'loading') {
        malaishaGetAlbum().then(r => console.log('DONE malaishaGetAlbum()'));
    } else {
        document.addEventListener('DOMContentLoaded', fn);
    }
}

console.log('Malaisha MAIN-TS');