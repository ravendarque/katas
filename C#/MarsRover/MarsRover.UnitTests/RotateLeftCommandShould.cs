using FluentAssertions;
using NUnit.Framework;

namespace MarsRover.UnitTests
{
    internal class RotateLeftCommandShould
    {
        [TestCase(Orientation.N, Orientation.W)]
        [TestCase(Orientation.E, Orientation.N)]
        [TestCase(Orientation.S, Orientation.E)]
        [TestCase(Orientation.W, Orientation.S)]
        public void RotateToNextOrientationOnLCommand(Orientation testOrientation, Orientation expectedOrientation)
        {
            const int dummyX = 1;
            const int dummyY = 1;
            var testPosition = new Position(dummyX, dummyY, testOrientation);
            const int testGridSizeX = 3;
            const int testGridSizeY = 3;
            var testTrackingModule = new TrackingModule
            {
                GridMaximumX = testGridSizeX,
                GridMaximumY = testGridSizeY,
                Position = testPosition
            };

            var spyCommand = new SpyCommand();
            var rotateCommand = new RotateLeftCommand(spyCommand);
            rotateCommand.Execute(testTrackingModule);

            var actualTrackingModule = spyCommand.TrackingModule;

            actualTrackingModule.Position.Orientation.Should().Be(expectedOrientation);
        }
    }
}