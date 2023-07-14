window.addEventListener('DOMContentLoaded', () => {
    const video = document.getElementById('videoPlayer') as HTMLVideoElement;
    const playButton = document.getElementById('playButton') as HTMLButtonElement;
    const pauseButton = document.getElementById('pauseButton') as HTMLButtonElement;
    const fullscreenButton = document.getElementById('fullscreenButton') as HTMLButtonElement;
    const volumeSlider = document.getElementById('volumeSlider') as HTMLInputElement;

    playButton.addEventListener('click', () => {
        video.play();
    });

    pauseButton.addEventListener('click', () => {
        video.pause();
    });

    fullscreenButton.addEventListener('click', () => {
        if (video.requestFullscreen) {
            video.requestFullscreen();
        } else if (video.mozRequestFullScreen) {
            video.mozRequestFullScreen();
        } else if (video.webkitRequestFullscreen) {
            video.webkitRequestFullscreen();
        } else if (video.msRequestFullscreen) {
            video.msRequestFullscreen();
        }
    });

    volumeSlider.addEventListener('input', () => {
        video.volume = parseFloat(volumeSlider.value);
    });