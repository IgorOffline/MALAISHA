<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
            rel="stylesheet"
    />
    <title>The Overdesign Poem</title>
</head>

<body style="padding: 5% 20% 5% 20%">
<h1>The Overdesign Poem</h1>
<p><i>Also known as: Why I hate modern software development</i></p>
<button id="playButton" name="playButton">Play sound</button>
<script type="module">
    const audio = new Audio('/audio/malaisha-intro.wav');
    audio.volume = 0.5;
    document.getElementById('playButton').addEventListener('click', () => {
        audio.play().catch(err => console.log(err));
    })
</script>
<p>
    As a software developer<br />
    I faced a problem<br />
    A challenge of the most challenging variety
</p>
<p>
    And then, I discovered <em>kubernetes</em><br />
    And suddenly, I had 32 problems
</p>
<p>
    And then, I discovered <em>kafka</em><br />
    And suddenly, I had 256 problems
</p>
</body>
</html>