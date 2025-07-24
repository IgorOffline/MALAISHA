const urlApiAlbum = '/api/album';

async function malaishaGetAlbum() {
    const responseRaw = await fetch(urlApiAlbum);
    const response = await responseRaw.json();

    console.log("response= ", response);
}

export function malaishaReady(fn: (this: Document, ev: Event) => any) {
    if (document.readyState !== 'loading') {
        malaishaGetAlbum().then(r => console.log('DONE malaishaGetAlbum()'));
    } else {
        document.addEventListener('DOMContentLoaded', fn);
    }
}

console.log('Malaisha MAIN-TS');