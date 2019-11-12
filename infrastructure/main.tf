provider "google" {
	credentials = "${file("credentials.json")}"
	project     = "roman-conversion"
	region      = "europe-west1"
}