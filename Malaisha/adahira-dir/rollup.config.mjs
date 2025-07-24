import {nodeResolve} from '@rollup/plugin-node-resolve';
import typescript from 'rollup-plugin-typescript2';

export default {
    input: 'src/main.ts',
    output: {
        file: 'dist/bundle.js',
        format: 'es',
        sourcemap: true
    },
    treeshake: false,
    plugins: [
        nodeResolve({
            browser: true,
            preferBuiltins: false
        }),
        typescript()
    ],
    onwarn(warning, warn) {
        if (warning.code === 'UNRESOLVED_IMPORT') {
            console.warn('> Unresolved import:', warning.source);
        } else {
            warn(warning);
        }
    }
};