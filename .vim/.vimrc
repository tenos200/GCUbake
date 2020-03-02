set nocompatible              
:inoremap jj <Esc> 
set rtp+=~/.vim/bundle/Vundle.vim
filetype plugin indent on    
set number
set t_Co=256
syntax on
set background=dark
let g:gruvbox_contrast_dark='hard'
colorscheme gruvbox
let g:ycm_autoclose_preview_window_after_insertion = 1
call vundle#rc()
highlight LineNr ctermfg=white
Plugin 'VundleVim/Vundle.vim'
Plugin 'scrooloose/nerdtree'
Plugin 'Valloric/YouCompleteMe'
Plugin 'morhetz/gruvbox'
call vundle#end()
autocmd FileType html setlocal ts=2 sts=2 sw=2
autocmd FileType ruby setlocal ts=2 sts=2 sw=2
autocmd FileType javascript setlocal ts=4 sts=4 sw=4
autocmd FileType java setlocal ts=2 sts=2 sw=2
:inoremap ( ()<Esc>i
:inoremap { {}<Esc>i
:inoremap " ""<Esc>i
:inoremap [ []<Esc>i
:inoremap ' ''<Esc>i






