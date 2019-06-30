var stompClient = null;

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });

    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
});

function connect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnection(true);
        console.log('Connected: ' + frame);

        stompClient.subscribe('/table/note', function (newNote) {
            var jsonBody = JSON.parse(newNote.body);
            displayNewNote(jsonBody.content, jsonBody.timestamp, jsonBody.longest_palindrome_size);
        });

        $("#connect").addClass('hidden');
        $("#disconnect, #notesTable").removeClass('hidden');
        $("#connection").text('Connected');
        $("#connection").css('color','green');
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnection(false);
    console.log("Disconnected");

    $("#connect").removeClass('hidden');
    $("#disconnect, #notesTable").addClass('hidden');

    $("#connection").text('Disconnected');
    $("#connection").css('color','red');
}

function setConnection(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#notesTable").show();
    }
    else {
        $("#notesTable").hide();
    }
    $("#notesBody").html("");
}

function displayNewNote(content, timestampEpoch, palindromeSize) {
    var row = document.createElement("tr");
    row.appendChild(tableColumn("Content", content));
    row.appendChild(tableColumn("Timestamp", formatDate(timestampEpoch)));
    row.appendChild(tableColumn("Longest Palindrome Size", palindromeSize));
    $("#notesBody").append(row);
}

function tableColumn(label, text) {
    var e = document.createElement("td");
    e.setAttribute("data-label", label);
    e.appendChild(document.createTextNode(text));
    return e;
}

function formatDate(timestampEpoch) {
    var myDate = new Date(timestampEpoch);
    return myDate.getFullYear() + '-' +
    ('0' + (myDate.getMonth()+1)).slice(-2) + '-' +
    ('0' + myDate.getDate()).slice(-2) + ' ' +
    ('0' + (myDate.getHours())).slice(-2) +  ':' +
    ('0' + (myDate.getMinutes())).slice(-2) + ':' +
    myDate.getSeconds() + '+0000';
}
