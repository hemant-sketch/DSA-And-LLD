const a = () => {
    console.log("world")
}

console.log("hello", a());

for(var i = 0; i < 4; i++) {
    setTimeout( ()=>{
        console.log(i);
    },100)
}

for(let i = 0; i < 4; i++) {
    setTimeout( ()=>{
        console.log(i);
    },100)
}
